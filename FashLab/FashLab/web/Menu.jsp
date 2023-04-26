<%-- 
    Document   : Menu.jsp
    Created on : Apr 26, 2023, 1:33:05 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="site-navbar" role="banner">
      <div class="site-navbar-top">
        <div class="container">
          <div class="row align-items-center">

            <div class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
                <form action="SearchController" method="post" class="site-block-top-search">
                <span class="icon icon-search2"></span>
                <input name="txt" type="text" class="form-control border-0" placeholder="Search">
                
              </form>
            </div>

            <div class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
              <div class="site-logo">
                <a href="HomePageController?action=Shop" class="js-logo-clone">FashLab</a>
              </div>
            </div>

            <div class="col-6 col-md-4 order-3 order-md-3 text-right">
              <div class="site-top-icons">
                <ul>
                  <li><a href="HomePageController?action=LogIn"><span class="icon icon-person"></span></a></li>
                  
                  <li>
                    <a href="cart.html" class="site-cart">
                      <span class="icon icon-shopping_cart"></span>
                      <span class="count">2</span>
                    </a>
                  </li> 
                  <li class="d-inline-block d-md-none ml-md-0"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu"></span></a></li>
                </ul>
              </div> 
            </div>

          </div>
        </div>
      </div> 
      <nav class="site-navigation text-right text-md-center" role="navigation">
        <div class="container">
          <ul class="site-menu js-clone-nav d-none d-md-block">
            <li class="active">
                <form action="HomePageController" >
                    <input type=hidden name="action" value="Home">
                    <input type="submit" value="Home">
                </form>
              
            </li>
            
            <li><form action="HomePageController" >
                    <input type=hidden name="action" value="Shop">
                    <input type="submit" value="Shop">
                </form></li>
            <li><form action="HomePageController" >
                    <input type=hidden name="action" value="NewArrivals">
                    <input type="submit" value="New Arrivals">
                </form></li>
            <li><form action="HomePageController" >
                    <input type=hidden name="action" value="Contact">
                    <input type="submit" value="Contact">
                </form></li>
          </ul>
        </div>
      </nav>
    </header>
