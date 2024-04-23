@import exercise.dto.users.UsersPage
@param UsersPage page
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
        <title>Пользователи</title>
    </head>
    <body>
        <div class="mx-auto p-4 py-md-5">
            <main>
                @if(page.getUsers().isEmpty())
                    <p>Пока не добавлено ни одного пользователя</p>
                @else
                    @for(var user: page.getUsers())
                        <div>
                            <h2><a href="/users/${user.getId()}">${user.getFirstName()}</a></h2>
                            <p>${user.getLastName()}</p>
                            <p>${user.getEmail()}</p>
                            <p>${user.getId()}</p>
                        </div>
                    @endfor
                @endif
            </main>
        </div>
    </body>
</html>