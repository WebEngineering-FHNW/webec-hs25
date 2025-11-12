%{--
renders a proper number input with value and range
parameters:
  name
  label
  step, min, max, value
--}%

<label for   ="${name}">${label}</label>
<input  id   ="${name}"
        name ="${name}" type="number"
        step ="${step}"
        min  ="${min}"
        max  ="${max}"
        value="${value}">
