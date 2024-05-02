<!-- src/main/jte/users/index.jte -->
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        @for(var user: page.getUsers())
            <div>
                <h2><a href="users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
                <p>${user.getEmail()}</p>
                <p>${user.getId()}</p>
            </div>
        @endfor
    @endif
    `
)

