package handlers

import ("github.com/gofiber/fiber/v2"
		"github.com/muhammad-rifqi/go_commerce/config"
)

func GetUsers(c *fiber.Ctx) error {
	rows, err := config.DB.Query("SELECT id,name,email FROM users")
	if err != nil {
		return c.Status(500).JSON(fiber.Map{
			"error": err.Error(),
		})
	}
	defer rows.Close()

	var users []fiber.Map

	for rows.Next() {
		var id int
		var name string
		var email string

		rows.Scan(&id, &name, &email)

		users = append(users, fiber.Map{
			"id":    id,
			"name":  name,
			"email": email,
		})
	}

	return c.JSON(users)
}

func GetUsersDetail(c *fiber.Ctx) error {
	id := c.Params("id")

	var userID int
	var name string
	var email string

	err := config.DB.QueryRow("select id, name, email from users where id = $1", id).Scan(&userID, &name, &email)

	if err != nil {
		return c.Status(404).JSON(fiber.Map{
			"error": "User tidak ditemukan",
		})
	}

	return c.JSON(fiber.Map{
		"id":    userID,
		"name":  name,
		"email": email,
	})

}