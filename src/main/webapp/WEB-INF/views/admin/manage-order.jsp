<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<main class="dash-content">
                <div class="container-fluid">
                    <h1 class="dash-title">Your order</h1>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-table"></i>
                                    </div>
                                    <div class="easion-card-title">Customer's orders</div>
                                </div>
                                <div class="card-body ">
                                    <table class="table table-hover table-in-card">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Phone</th>
                                                <th scope="col">Address</th>
                                                <th scope="col">Status</th>
                                                <th scope="col">Note</th>
                                                <th scope="col"></th>
                                                <th scope="col"></th>
                                                <th scope="col"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<tr>
                                                <th scope="row">1</th>
                                                <td scope="row">Viet Quoc</td>
                                                <td scope="row">0868955866</td>
                                                <td scope="row">788, Nguyen Xien,Thanh Xuan</td>
                                                <td scope="row">Waiting ...</td>
                                                <td scope="row"></td>
                                                <td><button type="button" class="btn btn-warning">SHIP</button></td>
                                                <td><button type="button" class="btn btn-danger">REJECT</button></td>
                                                <td><button type="button" class="btn btn-primary">ACCEPT</button></td>
                                            </tr>
                                            <tr>
                                                <th scope="row">2</th>
                                                <td scope="row">Dinh Tuan</td>
                                                <td scope="row">09785966358</td>
                                                <td scope="row">19, Nguyen Van Troi, Ha Dong</td>
                                                <td scope="row">Rejected</td>
                                                <td scope="row">Customer does not respond!</td>
                                                <td><button type="button" class="btn btn-warning">SHIP</button></td>
                                                <td><button type="button" class="btn btn-danger">REJECT</button></td>
                                                <td><button type="button" class="btn btn-primary">ACCEPT</button></td>
                                            </tr>
                                            <tr>
                                                <th scope="row">3</th>
                                                <td scope="row">Van Hoa</td>
                                                <td scope="row">0965975263</td>
                                                <td scope="row">278, Nguyen Trai, Thanh Xuan</td>
                                                <td scope="row">Accepted</td>
                                                <td scope="row"></td>
                                                <td><button type="button" class="btn btn-warning">SHIP</button></td>
                                                <td><button type="button" class="btn btn-danger">REJECT</button></td>
                                                <td><button type="button" class="btn btn-primary">ACCEPT</button></td>
                                            </tr>
                                            <tr>
                                                <th scope="row">4</th>
                                                <td scope="row">Van Hoang</td>
                                                <td scope="row">0978955866</td>
                                                <td scope="row">125, Chien Thang, Ha Dong</td>
                                                <td scope="row">Shipped</td>
                                                <td scope="row"></td>
                                                <td><button type="button" class="btn btn-warning">SHIP</button></td>
                                                <td><button type="button" class="btn btn-danger">REJECT</button></td>
                                                <td><button type="button" class="btn btn-primary">ACCEPT</button></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>