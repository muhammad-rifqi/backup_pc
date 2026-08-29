package main

import (
	"bytes"
	"encoding/json"
	"io"
	"net/http"

	"github.com/gofiber/fiber/v2"
	"github.com/gofiber/fiber/v2/middleware/cors"
)

type LoginRequest struct {
	Username string `json:"username"`
	Password string `json:"password"`
}

func vendorOptionHandler(c *fiber.Ctx) error {
url := "https://vendortest.siloamhospitals.com/tender/api/vendor/options"

	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		return c.Status(500).SendString(err.Error())
	}

	authHeader := c.Get("Authorization")
	req.Header.Set("Authorization", authHeader)
	req.Header.Set("Accept", "application/json")

	client := &http.Client{}
	resp, err := client.Do(req)
	if err != nil {
		return c.Status(500).SendString(err.Error())
	}
	defer resp.Body.Close()

	body, err := io.ReadAll(resp.Body)
	if err != nil {
		return c.Status(500).SendString(err.Error())
	}

	return c.
		Status(resp.StatusCode).
		Type("json").
		Send(body)
}

func productHandler(c *fiber.Ctx) error {

	id := c.Params("id")

	if id == "" {
		return c.Status(400).SendString("id is required")
	}

	url := "https://vendortest.siloamhospitals.com//tender/product/all/" + id

	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		return c.Status(500).SendString(err.Error())
	}

	authHeader := c.Get("Authorization")
	req.Header.Set("Authorization", authHeader)
	req.Header.Set("Accept", "application/json")

	client := &http.Client{}
	resp, err := client.Do(req)
	if err != nil {
		return c.Status(500).SendString(err.Error())
	}
	defer resp.Body.Close()

	body, err := io.ReadAll(resp.Body)
	if err != nil {
		return c.Status(500).SendString(err.Error())
	}

	return c.
		Status(resp.StatusCode).
		Type("json").
		Send(body)
}

func listTenderAll(c *fiber.Ctx) error {
	url := "https://vendortest.siloamhospitals.com/tender/api/tender/all"

	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		return c.Status(500).SendString(err.Error())
	}

	authHeader := c.Get("Authorization")
	req.Header.Set("Authorization", authHeader)
	req.Header.Set("Accept", "application/json")

	client := &http.Client{}
	resp, err := client.Do(req)
	if err != nil {
		return c.Status(500).SendString(err.Error())
	}
	defer resp.Body.Close()

	body, err := io.ReadAll(resp.Body)
	if err != nil {
		return c.Status(500).SendString(err.Error())
	}

	return c.
		Status(resp.StatusCode).
		Type("json").
		Send(body)
}

func loginHandler(c *fiber.Ctx) error {
	var reqBody LoginRequest

if err := c.BodyParser(&reqBody); err != nil {
	return c.Status(fiber.StatusBadRequest).JSON(fiber.Map{
		"error": "Invalid request body",
	})
}

jsonData, err := json.Marshal(reqBody)
if err != nil {
	return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
		"error": err.Error(),
	})
}

resp, err := http.Post(
	"https://vendortest.siloamhospitals.com/tender/api/auth/login",
	"application/json",
	bytes.NewBuffer(jsonData),
)
if err != nil {
	return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
		"error": err.Error(),
	})
}
defer resp.Body.Close()

body, err := io.ReadAll(resp.Body)
if err != nil {
	return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
		"error": err.Error(),
	})
}

return c.Status(resp.StatusCode).Send(body)

}

func logoutHandler(c *fiber.Ctx) error {
	url := "https://vendortest.siloamhospitals.com/tender/api/auth/logout"

	authHeader := c.Get("Authorization")
	if authHeader == "" {
		return c.Status(fiber.StatusUnauthorized).
			JSON(fiber.Map{"error": "Authorization token required"})
	}

	req, err := http.NewRequest("POST", url, nil)
	if err != nil {
		return c.Status(500).SendString(err.Error())
	}

	req.Header.Set("Authorization", authHeader)
	req.Header.Set("Content-Type", "application/json")

	client := &http.Client{}
	resp, err := client.Do(req)
	if err != nil {
		return c.Status(500).SendString(err.Error())
	}
	defer resp.Body.Close()

	body, _ := io.ReadAll(resp.Body)

	return c.Status(resp.StatusCode).
		Type("json").
		Send(body)
}


func main() {
	app := fiber.New()
	 app.Use(cors.New(cors.Config{
        AllowOrigins: "http://localhost:5173,http://127.0.0.1:5173",
        AllowHeaders: "Origin, Content-Type, Accept, Authorization",
        AllowMethods: "GET,POST,PUT,DELETE,OPTIONS",
        AllowCredentials: true,
    }))
	app.Post("/login", loginHandler)
	app.Get("/listtender", listTenderAll)
	app.Post("/logout", logoutHandler)
	app.Get("/product/:id", productHandler)
	app.Get("/vendor/option", vendorOptionHandler)
	app.Get("/", func(c *fiber.Ctx) error {
		return c.SendString("Hello, World!")
	})

	app.Listen(":3000")
}
