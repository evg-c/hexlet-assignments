@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@if(page.getError() != null)
    ${page.getError()}
@endif
<form action="${NamedRoutes.loginPath()}" method="post">
    <input type="text" placeholder="LogName" name="name" />
    <input type="text" placeholder="Password" name="password" />
    <input type="submit" />
</form>