<!-- src/main/jte/users/show.jte -->

@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <div>
            <h2><a href="users/${page.getUser().getId()}">${page.getUser().getFirstName()} ${page.getUser().getLastName()}</a></h2>
            <p>${page.getUser().getEmail()}</p>
            <p>${page.getUser().getId()}</p>
        </div>
    `
)
