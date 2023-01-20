<?php
$conn=mysqli_connect("localhost","root","");
mysqli_select_db($conn,"apidb");

  $name=trim($_POST['name']);
  $email=trim($_POST['email']);  
  $pswd=trim($_POST['password']);    

  $qry1="select * from tbl_user where email='$email'"; 
  $raw=mysqli_query($conn,$qry1);
  $count=mysqli_num_rows($raw);
  
  if($count>0)
   {
    $response['message']="exist";
   }
   else
   {
	   $qry2="INSERT INTO `tbl_user` (`id`, `name`, `email`, `password`) 
	          VALUES (NULL, '$name', '$email', '$pswd')";  
	   $res=mysqli_query($conn,$qry2);
	   if($res==true)
	   $response['message']="inserted";
	   else
	   $response['message']="failed";		  
   }
	
  echo json_encode($response);
  
?>