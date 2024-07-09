@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hello User!</title>
    </head>
    <body>
        <main>
            @if(page.getName() == null)
                <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
            @else
                Добро пожаловать, ${page.getName().toString()}!
                <form action="${NamedRoutes.logoutPath()}" method="post" >
                    <input type="submit" value="Выйти">
                </form>
            @endif
        </main>
    </body>
</html>
