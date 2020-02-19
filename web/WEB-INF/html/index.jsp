<%-- Created by IntelliJ IDEA. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <title>SiteName - Обмен валют</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <script src="https://d3js.org/d3.v5.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"> -->
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</head>
<body>
<h6>Обмен валют</h6>
<!--<script type="text/javascript" src="<c:url value="/resources/js/graph.js"/>"> -->
<script type="text/javascript">
  window.onload = function() {

    var dps = [[]];
    var chart = new CanvasJS.Chart("chartContainer", {
      theme: "light2", // "light1", "dark1", "dark2"
      animationEnabled: true,
      title: {
        text: "Currency value"
      },
      subtitles: [{
        text: "test"
      }],
      axisY: {
        title: "value"
      },
      data: [{
        type: "spline",
        showInLegend: true,
       // xValueFormatString: "####",
        name: "Buy",
        dataPoints: dps[0]
      },
        {
          type: "spline",
          showInLegend: true,
         // xValueFormatString: "####",
          name: "Sale",
          dataPoints: dps[0]
        }]
    });

    var xValue;
    var yValue;

    <c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
    <c:forEach items="${dataPoints}" var="dataPoint">
    xValue = parseInt("${dataPoint.x}");
    yValue = parseFloat("${dataPoint.y}");
    dps[parseInt("${loop.index}")].push({
      x : xValue,
      y : yValue
    });
    </c:forEach>
    </c:forEach>

    chart.render();

  }
</script>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<p>Валютные пары</p>
<select>
  <option>USD</option>
  <option>RUS</option>
  <option>EURO</option>
  <option>TENGE</option>
</select>
<button type="button" class="btn btn-default btn-sm">
  <span class="glyphicon glyphicon-transfer" aria-hidden="true"></span> Transfer </button>
<select>
  <option>USD</option>
  <option>RUS</option>
  <option>EURO</option>
  <option>TENGE</option>
</select>

<form:form action="saveCurrencyBuy" method="post" modelAttribute="currencyBuy">
  <p>Покупка USD</p>
  <table class="table">
    <tr>
      <td>Цена</td>
      <td><form:input path="valueBuy"/></td>
    </tr>
    <tr>
      <td>Количество</td>
      <td><form:input path="amountBuy"/></td>
    </tr>
    <tr>
      <td>Итого</td>
      <td><form:input path="resultBuy"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Покупка" onclick="buttonBuy()">
        <script type="text/javascript">
          function buttonBuy() {
            alert("Данные занесены в 'Заявки на покупку'");
          }
        </script></td>
    </tr>
  </table>
</form:form>

<form:form action="saveCurrencyAddHistory" method="post" modelAttribute="currencySale">
  <p>Лимитная заявка</p>
  <table class="table">
    <tr>
      <td>Цена</td>
      <td><form:input path="value"/></td>
    </tr>
    <tr>
      <td>Лимитная заявка</td>
      <td><form:input path="limitOrder"/></td>
    </tr>
    <tr>
      <td>Количество</td>
      <td><form:input path="amount"/></td>
    </tr>
    <tr>
      <td>Итого</td>
      <td><form:input path="result"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Покупка"><input type ="submit" value="Продажа"></td>
    </tr>
  </table>
</form:form>

<form:form action="saveCurrencySale" method="post" modelAttribute="currencyAddHistory">
  <p>Продажа USD</p>
  <table class="table">
    <tr>
      <td>Цена</td>
      <td><form:input path="valueSale"/></td>
    </tr>
    <tr>
      <td>Количество</td>
      <td><form:input path="amountSale"/></td>
    </tr>
    <tr>
      <td>Итого</td>
      <td><form:input path="resultSale"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Продажа" onclick="buttonSale()"><script type="text/javascript">
        function buttonSale()
        {
          alert("Данные занесены в 'Заявки на продажу'");
        }
      </script></td>
    </tr>
  </table>
</form:form>

<p>
  <caption>Заявка на продажу</caption>
<table class="table">
  <tr>
    <th>Цена</th>
    <th>RUB</th>
    <th>USD</th>
  </tr>
  <c:forEach var="currency" items="${buyList}" varStatus="status">
    <tr>
      <td><c:out value="${currency.value}"/> </td>
      <td><c:out value="${currency.amount}"/> </td>
      <td><c:out value="${currency.result}"/> </td>
    </tr>
  </c:forEach>
</table>

<p>
  <caption>Заявка на покупку</caption>
<table class="table">
  <tr>
    <th>Цена</th>
    <th>RUR</th>
    <th>USD</th>
  </tr>
  <c:forEach var="currency" items="${saleList}" varStatus="status">
    <tr>
      <td><c:out value="${currency.value}"/> </td>
      <td><c:out value="${currency.amount}"/> </td>
      <td><c:out value="${currency.result}"/> </td>
    </tr>
  </c:forEach>
</table>

<p>
  <caption>Торговая история</caption>
<table class="table">
  <tr>
    <th>Дата</th>
    <th>Тип</th>
    <th>Цена(USD)</th>
    <th>Кол-во(RUR)</th>
    <th>Итого(USD)</th>
  </tr>
  <c:forEach var="currency" items="${list}" varStatus="status">
    <tr>
      <td><c:out value="${currency.date}"/> </td>
      <!-- <td><c:out value="${currency.type}"/> </td> -->
      <td><c:out value="${currency.value}"/> </td>
      <td><c:out value="${currency.amount}"/> </td>
      <td><c:out value="${currency.result}"/> </td>
    </tr>
  </c:forEach>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
          crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
          integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
          crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
          integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
          crossorigin="anonymous"></script>
</table>
</body>
</html>