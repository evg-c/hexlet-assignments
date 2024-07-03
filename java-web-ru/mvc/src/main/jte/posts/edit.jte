@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@param EditPostPage page

@template.layout.page(
    content = @`
        @if(page.getErrors() != null)
            <div>
                <ul>
                    @for(var validator: page.getErrors().values())
                        @for(var error: validator)
                            <li>
                                ${error.getMessage()}
                            </li>
                        @endfor
                    @endfor
                </ul>
            </div>
        @endif
    
        <div>
            <form action="${NamedRoutes.editPathId(page.getId())}" method="post">
                <div>
                    <label>
                        Название
                        <input type="text" name="name" value="${page.getName()}" />
                    </label>
                </div>
                <div>
                    <label>
                        Содержание
                        <textarea rows="20" cols="70" type="text" name="body">${page.getBody()}</textarea>
                    </label>
                </div>
                <input type="submit" value="Изменить" />
            </form>
        </div>
    `
)