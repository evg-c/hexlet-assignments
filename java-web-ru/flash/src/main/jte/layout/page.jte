
@import gg.jte.Content
@import exercise.dto.BasePage

@param Content content
@param BasePage page = null

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="view-port" content="width=device-wodth, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
              crossorigin="anonymous">
        <title>Posts</title>
    </head>
    <body>
        @if(page != null && page.getFlash() != null)
            <div class="alert alert-success" role="alert">
                <p>${page.getFlash()}</p>
            </div>
        @endif
        <div class="content">
            ${content}
        </div>
    </body>
</html>
<!-- END -->
