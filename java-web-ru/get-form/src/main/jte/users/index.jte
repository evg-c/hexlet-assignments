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
                    <tr>
                        <td>
                            ${user.getId()}
                        </td>
                        <td>
                            <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                        </td>
                    </tr>
                </div>
            @endfor
        @endif
        <form action="/users" method="get">
            <input type="search" required name="term" value="${page.getTerm()}" />
            <input type="submit" value="Искать" />
        </form>
    `
)
