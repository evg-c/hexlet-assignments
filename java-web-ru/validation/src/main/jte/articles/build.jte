@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@if(page.getErrors() != null)
    <ul>
        @for(var validator: page.getErrors().values())
            @for(var error: validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="view-port" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
              crossorigin="anonymous">
        <title>Articles build example</title>
    </head>
</html>

<form action="/articles" method="post">
    <div>
        <label>
            Название
            <input type="text" name="title" value="${page.getTitle()}" />
        </label>
    </div>
    <div>
        <label>
            Содержание
            <input type="textarea" name="content" value="${page.getContent()}" />
        </label>
    </div>
    <input type="submit" value="Создать" />
</form>
