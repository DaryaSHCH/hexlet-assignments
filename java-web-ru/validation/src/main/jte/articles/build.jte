<!-- BEGIN -->
@import exercise.dto.articles.NewArticlePage
@param NewArticlePage page

@template.layout.page(
 content = @`
     @if(page.getErrors() != null)
         <ul>
             @for(var validator : page.getErrors().values())
                 @for(var error : validator)
                     <li>${error.getMessage()}</li>
                 @endfor
             @endfor
         </ul>
     @endif
     <form action="/articles" method="post">
         <div>
             <label>
                 Заголовок
                 <input type="text" name="title" value="${page.getTitle()}"/>
             </label>
         </div>
         <div>
             <label>
                 Содержание
                 <textarea type="text" name="content">${page.getContent()}></textarea>
             </label>
         </div>
         <input type="submit" value="Опубликовать"/>
     </form>
 `
 )
<!-- END -->
