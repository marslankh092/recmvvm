<?php
$conn=mysqli_connect("localhost","root","");
mysqli_select_db($conn,"apidb");

  $email=trim($_POST['email']);  
  $pswd=trim($_POST['password']);    

  $qry="select * from tbl_user where email='$email' and password='$pswd'"; 
  $raw=mysqli_query($conn,$qry);
  $count=mysqli_num_rows($raw);
  
  if($count>0)
   {
    $response['message']="exist";
   }
   else
   {
   $response['message']="failed";		  
   }
	
    echo json_encode($response);
  
?>