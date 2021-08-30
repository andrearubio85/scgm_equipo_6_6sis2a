<?php
	include "conexion.php";

	EliminarProducto($_GET['no']);

	function EliminarProducto($no)
	{
		$sentencia="DELETE FROM productos WHERE no='".$no."' ";
		mysql_query($sentencia) or die (mysql_error());
	}
?>

<script type="text/javascript">
	alert("Producto Eliminado exitosamente");
	window.location.href='index.php';
</script>