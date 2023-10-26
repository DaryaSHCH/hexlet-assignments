<!-- BEGIN -->
@import exercise.dto.users.UserPage
@param UserPage page

<html>
<body>
<main>
    <h1>${page.getUser().getFirstName()}</h1>
    <p>${page.getUser().toString()}</p>
</main>
</body>
</html>
<!-- END -->
