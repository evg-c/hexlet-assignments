@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="view-port" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
        <title>Все посты</title>
    </head>

@template.layout.page(
    content = @`
        @if(page.getPosts().isEmpty())
            <p>Пока не добавлено ни одного поста</p>
        @else
            @for(var post: page.getPosts())
                <div>
                    <tr>
                        <td>
                            ${post.getId()}
                        </td>
                        <td>
                            <a href="${NamedRoutes.postsPath()}/${post.getId()}">${post.getName()}</a>
                        </td>
                    </tr>
                </div>



            @endfor
        @endif
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}/?page=${page.getNumberPage() - 1}">Назад</a></li>
                <li class="page-item"><a class="page-link" >${page.getNumberPage()}</a></li>
                <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath()}/?page=${page.getNumberPage() + 1}">Вперед</a></li>
            </ul>
        </nav>
    `
)

</html>


