<!--/Register-->
<div class="modal fade" id="exampleModalCenter2" tabindex="-1"
	role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header text-center">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="login px-4 mx-auto mw-100">
					<h5 class="text-center mb-4">Register Now</h5>
					<form action="#" method="post">
						<div class="form-group">
							<label>select Registration type</label> </br><input type="radio"
								name="gender" value="farmer"> Farmer<br> 
								<input type="radio" name="gender" value="agronomist" onclick="document.getElementById('type').removeAttribute('disabled')">Agronomist<br>
							<input type="radio" name="gender" value="company"> Company</br>
							
							 <label>First name</label>
								 <input type="text" class="form-control"
								id="firstname" name="firstname" placeholder="" required="">
						</div>
						<div class="form-group">
							<label>Last name</label> <input type="text" class="form-control"
								id="lastname" name="lastname" placeholder="" required="">
						</div>
						<div class="form-group">
							<label>Username</label> <input type="text" class="form-control"
								id="name" name="name" placeholder="" required="">
						</div>
						<div class="form-group">
							<label>Email</label> <input type="text" class="form-control"
								id="email" name="email" placeholder="" required="">
						</div>
						<div class="form-group">
							<label>Mobile No</label> <input type="text" class="form-control"
								id="mobileno" name="mobileno" placeholder="" required="">
						</div>


						<div class="form-group">
							<label class="mb-2">Password</label> <input type="password"
								class="form-control" id="password" name="password" placeholder="" required="">
						</div>
						<div class="form-group">
							<label>Confirm Password</label> <input type="password"
								class="form-control" id="password2" placeholder="" required="">
						</div>
						<div class="form-group">
						<label>Select Agronomist type</label> 
						 <select id="type" name="charstype" disabled>
                         <option>Agronomy</option>
                          <option>Horticulture</option>
                          <option>live stock</option>
                          <option>soil science</option>
                          <option>Plantbreeding</option>
                          <option>antmology</option>
                          <option>mmeterology</option>
                          <option>equipments experts</option>
                           </select>
						</div>
						<div class="form-group">
						<button type="submit" class="btn btn-primary submit mb-4">Register</button>
						<p class="text-center pb-4">
							<a href="#">By clicking Register, I agree to your terms</a>
						</p>
					</form>

				</div>
			</div>

		</div>
	</div>
</div>
<!--//Register-->