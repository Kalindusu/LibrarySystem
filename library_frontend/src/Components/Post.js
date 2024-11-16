import React, { useState } from "react";
import "./postUser.css";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";

const PostUser = () => {
  const [formData, setFormData] = useState({

    id:"",
    name: "",
    email: "",
    phone: "",
    department: "",
    password:""
    
  });

  const handleInputChange = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setFormData({ ...formData, [name]: value });
  };
  const navigate=useNavigate();
  const handlesubmit = async (e) => {
    e.preventDefault();
    try{
const response=await fetch("",{
  method:"POST",
  headers:{
    "Content-Type":"application/json"
  },
  body:JSON.stringify(formData)
});

const data=await response.json();
console.log("Employee created",data);
alert("Books Added Succesfully")
navigate("/")
    }catch(error){
        alert("Error in adding books please refill the form")
        console.log("Error message")

    }
  };
  return (
    <div className="center-form">
      <h1>Post Employee</h1>
      <form onSubmit={handlesubmit}>
        <Form.Group className="mb-3" controlId="formBasicName">
          <Form.Control
            type="text"
            placeholder="Enter Name"
            name="name"
            value={formData.name}
            onChange={handleInputChange} 
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Control
            type="email"
            placeholder="Enter Email"
            name="email"
            value={formData.email}
            onChange={handleInputChange} 
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicPhone">
          <Form.Control
            type="text"
            placeholder="Enter Contact No"
            name="phone"
            value={formData.phone}
            onChange={handleInputChange} 
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Control
            type="password"
            placeholder="Enter password"
            name="password"
            value={formData.password}
            onChange={handleInputChange} 
          />
        </Form.Group>
        <Button variant="primary" type="submit" className="w-100">
          Post Employee
        </Button>
      </form>
    </div>
  );
};

export default PostUser;
