@import gg.jte.Content
@import exercise.dto.posts.PostsPage

@param PostsPage page
@param Content content

@template.layout.page(
    page = page,
    content = @`
        @if(page.getPosts().isEmpty())
            <p>Пока не добавлено ни одного поста</p>
        @else
            @for(var post: page.getPosts())
                <div>
                    <tr>
                        <td>
                            ${post.getName()} ${post.getBody()}
                        </td>
                    </tr>
                </div>
            @endfor
        @endif
    `
)

