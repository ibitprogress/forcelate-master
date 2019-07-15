# forcelate

БД - MySQL віддалена, пуста, при запуску проекту бд наповниться рандомними даними(дані генеруються в класі з методом main), підключення до бази настроєне в application.properties. https://my.gearhost.com/ - тут знаходиться бд.

color (enum): RED,BLUE,BLACK,GREEN,ORANGE,WHITE;

- Дістати всіх Users, в яких age більше за якесь значення:
localhost:8080/user/age/2 - замість 2 любе значення

- Дістати всіх Users з Articles, в яких color якесь певне значення з enum-а:
localhost:8080/user/color?color=RED - замість RED любий колір з enum-a

 - Дістати унікальні name з Users, в яких більше ніж 3 Articles:
 localhost:8080/user/art/3 - замість 3 можна вказати любе значення
 
 - Зберегти User:
 localhost:8080/user/
{
	"name":"name",
	"age":"23"
}

- Зберегти Article:
localhost:8080/article/
{
	"text": "rrrr",
	"color": "RED",
	"user": {
		"id":1 - вказувати id існуючого юзера
	}
}

тести нормально не написані, розбираюсь як їх писати


