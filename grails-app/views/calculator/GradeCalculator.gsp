<!doctype html>
<html lang="en">
<head>
    <title>
        Grade Calculator
    </title>
    <style>
        html {
            font-family: system-ui;
        }
        form {
            padding:        1em;
            box-shadow:     .2em .2em .5em lightgray;
            max-width:      60ch;
            margin-inline:  auto;
            margin-top:     2em;
            display:        grid;
            grid-template-columns: max-content max-content;
            gap:            .5em 1em;
        }
    </style>
</head>
<body>

<form action="/calculator/calc" method="get">

    <tmpl:input_row name="tec" label="technical value (1.0 - 6.0)"
      min="1" max="6" step="0.1" value="4"></tmpl:input_row>
    <tmpl:input_row name="own" label="own contribution %"
      min="0" max="100" step="1" value="80"></tmpl:input_row>

    <input type="submit">
</form>
</body>
</html>
