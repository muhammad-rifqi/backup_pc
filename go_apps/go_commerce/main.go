package main

import ("github.com/gofiber/fiber/v2"
		"github.com/muhammad-rifqi/go_commerce/config"
		"github.com/muhammad-rifqi/go_commerce/handlers"
)

func main() {
	config.ConnectDB()

	app := fiber.New()
		
	app.Static("/", "./views")
	
	app.Get("/buah", handlers.HandlerArray)

	app.Get("/users", handlers.GetUsers)

	app.Get("/users/:id", handlers.GetUsersDetail)

	app.Get("/", func(c *fiber.Ctx) error {
		return c.SendFile("./views/index.html")
	})

	app.Get("/profile", func(c *fiber.Ctx) error {
		return c.SendFile("./views/profile.html")
	})
	app.Listen(":3000")
}

