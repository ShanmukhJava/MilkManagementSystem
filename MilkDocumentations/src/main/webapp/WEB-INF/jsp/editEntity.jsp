<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Entity</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
    <style>
      .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1>Edit Entity</h1>
        <form:form action="/entities/update/${entity.id}" method="post" modelAttribute="entity" id="entityForm" class="needs-validation" novalidate="novalidate" enctype="multipart/form-data">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="firstName">First Name:</label>
                    <form:input path="firstName" id="firstName" class="form-control" required="required"/>
                </div>
                <div class="form-group col-md-6">
                    <label for="middleName">Middle Name:</label>
                    <form:input path="middleName" id="middleName" class="form-control"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="lastName">Last Name:</label>
                    <form:input path="lastName" id="lastName" class="form-control" required="required"/>
                </div>
                <div class="form-group col-md-6">
                    <label for="email">Email:</label>
                    <form:input path="email" id="email" class="form-control" required="required" email="true"/>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="associationDate">Association Date:</label>
                    <form:input path="associationDate" id="associationDate" type="date" class="form-control" required="required"/>
                </div>
                <div class="form-group col-md-6">
                    <label for="contactNo">Contact Number:</label>
                    <form:input path="contactNo" id="contactNo" class="form-control" required="required" pattern="\d{10}"/>
                </div>
            </div>
            <div class="form-group">
                <label>Gender:</label>
                <div class="form-check">
                 <form:radiobutton path="gender" id="male" value="Male" class="form-check-input" ${entity.gender == 'Male'? 'checked' : ''}/>
                    <label class="form-check-label" for="male">Male</label>
                </div>
                <div class="form-check">
                  <form:radiobutton path="gender" id="female" value="Female" class="form-check-input" ${entity.gender == 'Female'? 'checked' : ''}/>
                    <label class="form-check-label" for="female">Female</label>
                </div>
            </div>
            <div class="form-group">
                <label>Interests:</label>
                <div class="form-check">
                    <form:checkbox path="interests" value="Sports" id="sports" class="form-check-input" ${entity.interests.contains('Sports')? 'checked' : ''}/>
                    <label class="form-check-label" for="sports">Sports</label>
                </div>
                <div class="form-check">
                    <form:checkbox path="interests" value="Music" id="music" class="form-check-input" ${entity.interests.contains('Music')? 'checked' : ''}/>
                    <label class="form-check-label" for="music">Music</label>
                </div>
                <div class="form-check">
                    <form:checkbox path="interests" value="Reading" id="reading" class="form-check-input" ${entity.interests.contains('Reading')? 'checked' : ''}/>
                    <label class="form-check-label" for="reading">Reading</label>
                </div>
            </div>
            <div class="form-group">
                <label for="country">Country:</label>
                <form:select path="country" id="country" class="form-control">
                    <form:option value="" label="-- Select Country --"/>
                    <form:options items="${countryList}"/>
                </form:select>
            </div>
            
            <div class="form-group">
                <label for="profilePicture">Profile Picture:</label>
                <form:input path="profilePicturePath" id="profilePicture" name="profilePicture" class="form-control-file"/>
            </div>
            <button type="submit" class="btn btn-primary">Update Entity</button>
        </form:form>
    </div>

    <script>
        $(document).ready(function() {
            $("#entityForm").validate({
            	  rules: {
                      firstName: {
                          required: true
                      },
                      lastName: {
                          required: true
                      },
                      email: {
                          required: true,
                          email: true
                      },
                      associationDate: {
                          required: true,
                          date: true
                      },
                      contactNo: {
                          required: true,
                          digits: true,
                          minlength: 10,
                          maxlength: 10
                      },
                      gender: {
                          required: true
                      },
                      country: {
                          required: true
                      },
                      profilePicture: {
                          required: true,
                          extension: "jpg|jpeg|png|gif"
                      }
                  },
                      
                  
                  messages: {
                      firstName: {
                          required: "Please enter the first name"
                      },
                      lastName: {
                          required: "Please enter the last name"
                      },
                      email: {
                          required: "Please enter an email address",
                          email: "Please enter a valid email address"
                      },
                      associationDate: {
                          required: "Please enter the association date",
                          date: "Please enter a valid date"
                      },
                      contactNo: {
                          required: "Please enter the contact number",
                          digits: "Please enter a valid contact number",
                          minlength: "Contact number must be 10 digits",
                          maxlength: "Contact number must be 10 digits"
                      },
                      gender: {
                          required: "Please select a gender"
                      },
                      country: {
                          required: "Please select a country"
                      },
                      profilePicture: {
                          required: "Please upload a profile picture",
                          extension: "Please upload a valid image file (jpg, jpeg, png, gif)"
                      }
                  },
                  errorElement: "div",
                  errorPlacement: function(error, element) {
                      error.addClass("error");
                      error.insertAfter(element);
                  },
                  highlight: function(element) {
                      $(element).addClass('is-invalid');
                  },
                  unhighlight: function(element) {
                      $(element).removeClass('is-invalid');
                  }
              });
          
              $("#associationDate").flatpickr({
                  dateFormat: "Y-m-d"
              });
          });
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
