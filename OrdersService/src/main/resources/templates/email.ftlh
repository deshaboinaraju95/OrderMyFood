<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>A simple, clean, and responsive HTML invoice template</title>

		<style>
			.invoice-box {
				max-width: 800px;
				margin: auto;
				padding: 30px;
				border: 1px solid #eee;
				box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
				font-size: 16px;
				line-height: 24px;
				font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
				color: #555;
			}

			.invoice-box table {
				width: 100%;
				line-height: inherit;
				text-align: left;
			}

			.invoice-box table td {
				padding: 5px;
				vertical-align: top;
			}

			.invoice-box table tr td:nth-child(2) {
				text-align: right;
			}

			.invoice-box table tr.top table td {
				padding-bottom: 20px;
			}

			.invoice-box table tr.top table td.title {
				font-size: 45px;
				line-height: 45px;
				color: #333;
			}

			.invoice-box table tr.information table td {
				padding-bottom: 40px;
			}

			.invoice-box table tr.heading td {
				background: #eee;
				border-bottom: 1px solid #ddd;
				font-weight: bold;
			}

			.invoice-box table tr.details td {
				padding-bottom: 20px;
			}

			.invoice-box table tr.item td {
				border-bottom: 1px solid #eee;
			}

			.invoice-box table tr.item.last td {
				border-bottom: none;
			}

			.invoice-box table tr.total td:nth-child(2) {
				border-top: 2px solid #eee;
				font-weight: bold;
			}

			@media only screen and (max-width: 600px) {
				.invoice-box table tr.top table td {
					width: 100%;
					display: block;
					text-align: center;
				}

				.invoice-box table tr.information table td {
					width: 100%;
					display: block;
					text-align: center;
				}
			}

			/** RTL **/
			.invoice-box.rtl {
				direction: rtl;
				font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
			}

			.invoice-box.rtl table {
				text-align: right;
			}

			.invoice-box.rtl table tr td:nth-child(2) {
				text-align: left;
			}
		</style>
	</head>

	<body>
		<div class="invoice-box">
			<table cellpadding="0" cellspacing="0">
				<tr class="top">
					<td colspan="2">
						<table>
							<tr>
								<td class="title" align ="center" >
									Online Food Order Delivery Invoice
								</td>

							
							</tr>
						</table>
					</td>
				</tr>

				<tr class="information">
					<td colspan="2">
						<table>
							<tr>
							
								<td>
								Restaurant Details<br>
								
									Name    :${restaurantandlocation.restaurantName}<br />
									Address :${restaurantandlocation.address}<br/>
									         ${restaurantandlocation.city}<br/>
									         ${restaurantandlocation.state}<br/>
									         ${restaurantandlocation.zipcode?c}<br/>
								
								</td>

								<td>
									Customer Details<br>
								
									Name    :${user.userName}<br />
									Address :${userlocation.address}<br/>
									         ${userlocation.city}<br/>
									         ${userlocation.state}<br/>
									         ${userlocation.zipcode?c}<br/>
									         ${user.mobileNumber?c}<br/>
									         ${user.emilId}<br/>
								
								</td>
								</td>
							</tr>
						</table>
					</td>
				</tr>

				

				<tr class="heading">
					<td>Item</td>

					<td>Quantity</td>
					<td>Price</td>
				</tr>
				
               <#list itemlist as i>
				<tr class="item">
					<td>${i.name}</td>
					<td>${i.qunatity}</td>

					<td>₹${i.price *i.qunatity}</td>
				</tr>

				</#list>
				<tr class="total">
					<td></td>
					<td>Charges</td>

					<td>Total: ${charges?c}</td>
				</tr>

				<tr class="total">
					<td></td>
					<td></td>

					<td>Total: ${total?c}</td>
				</tr>
			</table>
		</div>
	</body>
</html>

