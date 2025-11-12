<!doctype html>
<html lang="en">
<head>
    <title>
        Calculated Grade
    </title>
</head>
<body>

<p> Your grade is
  <rooms:decorate grade="${ result }">
      <output>${ result }</output>
  </rooms:decorate>.
</p>



<p> Back to the <a href="${createLink(action: 'index')}">calculator</a> .</p>

</body>
</html>
