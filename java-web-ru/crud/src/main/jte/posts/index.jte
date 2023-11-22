<!-- BEGIN -->
@import exercise.dto.posts.PostsPage
@import exercise.controller.PostsController
@param PostsPage page

<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    <title>Hello Hexlet!</title>
    </head>
    <body>
        <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Posts</h1>
            <table class="table table-striped">
                @for(var post : page.getPosts())
                    <tr>
                        <td>
                            <a href="/posts/${post.getId()}">${post.getName()}</a>
                        </td>
                    </tr>
                @endfor
            </table>
		<div><a href="/posts?page=2">Forward</a></div>
		<div><a href="/posts?page=1">Back</a></div>
		<div><a href="/posts?page=3">Back</a></div>
        </main>
        </div>
    </body>
</html>
<!-- END -->
