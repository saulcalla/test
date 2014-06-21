<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<% String vFormulario 	= new String("ventaActualForm"); %>
<html>
<head>
    <meta charset="utf8">
    <meta http-equiv="refresh" content="300">
    <title>Ventas Ripley</title>
   	<link href='http://fonts.googleapis.com/css?family=Roboto:400,300' rel='stylesheet' type='text/css'>

   	<style>
   		html, body {
   			height:100%;
   			width: 100%;
        padding: 0;
        margin: 0;
   			font-family: 'Roboto', sans-serif;
   		}
   		body {
   			display: flex;
  			align-items: center;
  			justify-content: center;
   		}
   		.center {
   			position: relative;
   			width: 80%;
   		}
   	</style>
</head>
<body>

	<div class="center">

		<h1 style="font-size:6em; color:#644dad;"> VENTAS </h1>

		<img style="position:absolute; right:0; top: 90px;" alt="" src="data:image/gif;base64,R0lGODlhvQBDAMQfABwcG3kTaf/TAMgIKf///+lRUtrb3M4iF8bGxo6OjVVVVPHx8Tg4OOpZTaqqqXFxcc8sIs0iGEdHRuhQUuPj4ioqKYCAf5ubm9TU1Li4t2NjYxkZGckiGMonHeNQUf///yH/C1hNUCBEYXRhWE1QPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS4wLWMwNjEgNjQuMTQwOTQ5LCAyMDEwLzEyLzA3LTEwOjU3OjAxICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1wTU06T3JpZ2luYWxEb2N1bWVudElEPSJ4bXAuZGlkOjAzODAxMTc0MDcyMDY4MTE5NEZGQjg3QTVFMkFENzNFIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkVDRTQ4QjcwQ0ZCNDExRTJCOTVERDdGN0M0M0Y2MDcwIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkVDRTQ4QjZGQ0ZCNDExRTJCOTVERDdGN0M0M0Y2MDcwIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDUzUuMSBNYWNpbnRvc2giPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDowMTgwMTE3NDA3MjA2ODExODcxRkVDRDRBM0VGMjYzMiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDowMzgwMTE3NDA3MjA2ODExOTRGRkI4N0E1RTJBRDczRSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PgH//v38+/r5+Pf29fTz8vHw7+7t7Ovq6ejn5uXk4+Lh4N/e3dzb2tnY19bV1NPS0dDPzs3My8rJyMfGxcTDwsHAv769vLu6ubi3trW0s7KxsK+urayrqqmop6alpKOioaCfnp2cm5qZmJeWlZSTkpGQj46NjIuKiYiHhoWEg4KBgH9+fXx7enl4d3Z1dHNycXBvbm1sa2ppaGdmZWRjYmFgX15dXFtaWVhXVlVUU1JRUE9OTUxLSklIR0ZFRENCQUA/Pj08Ozo5ODc2NTQzMjEwLy4tLCsqKSgnJiUkIyIhIB8eHRwbGhkYFxYVFBMSERAPDg0MCwoJCAcGBQQDAgEAACH5BAEAAB8ALAAAAAC9AEMAAAX/ICCOZGmeaKqubOu+cCyrX01+c67vfO//AFvNBiwaj8jkDYcLKp/QqPQkFDWn2Kx2Jxxuv+AwargRba7itFo6bKPX8DjQ7ZXb7zo6Ec/vr/RvfoKCgIOGg4WHiniJi45wjY+SYZGTljwPCQkVLZUqDwShogQIFww5CKMOMAyjohimMBijCzsXrq4IMA6jFyUSFAQUDy6eKhWpGBIKD6kLxDOgBNAxGQQLEhIaqQQWMAqhqzwMC6QK5woJFLrfob4k5AQOnMV6MQmkJLwEpzOhOeDYiZCmAUYoBT5SJSihQOALXhToiUgl7oUxFfgcAgj2Tsa/GQFL8MpgkADCHgp//y2MUaHcSgCgSMa4mCJjCQv5/BEAmHOEhmslT/JI6QMnPxEUFki0aA+GTRIhdfLUKEFY0IQEXvaYpQuUNxk0UTwdAUpryakM5V1FmRWe2XYmEVDIEfbE2IlHpYLsKcKahLVD245woDEGr3JfwTZ9cRfn2xcfZUQFwMAaNRcHsS5AwLlcxxktQy2FUddERgaaMCxIrFcyqQvlMDjoB3hHMk0JYD+GcaswUzr3SFW4ReBz6xiTdWRmq/WBTB13Zy528dQo7ePtfMdYHlgrah7RSU9vMTaYdsw7956HbBLrbuh8pQN32vNnN+XpXa9HL9S2YCDh/eZGcA5x8xd2LySXA/93+sRAVAmxzBBgPfMxRgAG8JSDDYIu2NcDg5RhgCEMD4pQgQO15DBhJ+OtUEEwBBQ0AjjXHPiCUay9YM19OlQlDzoW7CijCy9eiM4DKP4ngzULXCdehSxIUI4oFNiowJQJOJnCLFTayEKRomwogzS4hHIZC1eWGU4OUo7yHg0t6lCBcwg8d8mdJZSG55496MnnnzP4CeigFA5I6KE8CIroonnGyeijKSgK6aKSTnpopZYOimmmf27K6Z6efnpnqKJaQmqpkpyKqiOAHODqqwdwEMCsAtRqq62iGKDrrgX06msBDdxa66zEFlssrK52sOuyBgzg7LPOEiuKsLYaW+z/rwV48Cy1teJiLbTggsusKNj6Sq21s4bbKrIHREAst92GwqwB5QJ7LrrGsgvBvLqGG+2s03KLbwDYTrAtt94a66+/44ZSbwH3fgvuusi6Syu8uTJbb7DCDnwssvvyu7C0ocA7cMEHU5twsQuH2zABD0es8MR6sNvuuxjLq3G5HN/qMbH68tusvyQTYDK+KDub8ygSt/zsyzF3jK66NbNrcQDwCpDxshvLPHDQIhMNcMkCI/2rwUoj7ErTTg8Adb1eE0s1HTZfnfXWvPIcN7pgzzvy2EaXjW7SAywtCttOv13u3gHM7UbdOKtNwLxdS/1z38z+HUDAjBN8dsrCrix3/9vOKo4t4463AfnFklOut+UeY76s5pzDbizhhoeCeMum/4o6zXRbHbnKOnP9us8/ByD7rrST3Tnukh8+M+m9m2v76NBSDKvdS7uObc/VJr98v2Jv7vz1xEJPPNPTt119r79nX3XFw4defN7fd/4xrCH7XX7tyBvc59K2PumxjHRuWxa54Ia+xgHvccJj3fq89yvwDUt8IBNa8wL3vAEWLnq6a1/iFOgwBgZQhAPQ3qu417qd5a+B+cpg2MJVtKMJ0Fdo+2ABQ3hA6pEQZiYM3+5U6CoWTtCFFdQf0GToPxoCzobWUp/92NdD9/0waiesorOIeDMJTpGCvrKgAJKnPFEmZu5/58vitTyYOwLsbmHvg1gDUzeE1WGte0gMoxJnNb6hOdF8HIShFG8lunQhMI7xexYXjfjFPPZKjGTs4waheDs2gtCNKITjFYN4wSHqIQQAOw==" />

		<!--AQUI SE PONE LA VARIABLE VENTAS -->
		<h2 style="font-size:5em;"><span style="color: #bbb;">HOY:</span> $<bean:write name="<%=vFormulario%>" property="ventaTotal"/> </h2>

		<div style="height:20px; width:100%; background-color:#ccc; margin-bottom:60px;"></div>

	</div>


</body>
</html>