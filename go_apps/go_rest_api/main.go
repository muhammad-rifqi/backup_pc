package main

import (
	"log"
	"github.com/gofiber/fiber/v2"
	"github.com/muhammad-rifqi/go_rest_api/database"
	"github.com/muhammad-rifqi/go_rest_api/handlers"
)

func main() {
	err := database.ConnectDB()
	if err != nil {
		log.Fatal(err)
	}
	defer database.DB.Close()

	app := fiber.New()
	app.Static("/", "./public")
	app.Get("/", handlers.Welcome)
	app.Get("/users", handlers.Home)
	app.Get("/users/:id", handlers.GetUserByID)
	app.Post("/users", handlers.CreateUser)
	app.Put("/users/:id", handlers.UpdateUser)
	app.Delete("/users/:id", handlers.DeleteUser)
	app.Post("/login", handlers.LoginUser)
	app.Get("/profile", handlers.Profile)
	log.Fatal(app.Listen(":3000"))
}

