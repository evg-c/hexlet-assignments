<!-- src/main/jte/layout/page.jte -->
@import gg.jte.Content
@param Content content

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="view-port" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                    rel="stylesheet"
                    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                    crossorigin="anonymous">
        <title>Hexlet Javalin Jte Layout Example</title>
    </head>
    <body>
        <header>
            <nav>
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/users">Users</a></li>
                </ul>
            </nav>
        </header>
        <div class="content">
            ${content}
        </div>
        <footer>
            <a href="https://evg-c.github.io">My GitHub</a>
        </footer>
    </body>
</html>
