package handlers

import "github.com/gofiber/fiber/v2"

func HandlerArray(c *fiber.Ctx) error {
	data := []string{"Apple", "Banana", "Orange", "Mango"}
	data = append(data, "Orange")
	return c.JSON(fiber.Map{
		"message": "Data Buah",
		"data":    data,
	})
}