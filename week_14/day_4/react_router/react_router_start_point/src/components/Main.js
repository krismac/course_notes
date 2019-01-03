import React, { Component } from "react";
import About from "./About";
import Home from "./Home";
import Pricing from "./Pricing";

class Main extends Component {
  constructor() {
    super();
    this.state = { page: null };

    this.gotoHome = this.gotoHome.bind(this);
    this.gotoAbout = this.gotoAbout.bind(this);
    this.gotoPricing = this.gotoPricing.bind(this);
  }

  render() {
    const child = this.pageComponent();
    return (
      <div>
        <h4>Main App</h4>
        <ul>
          <li>
            <a onClick={this.gotoHome}>Home</a>
          </li>
          <li>
            <a onClick={this.gotoAbout}>About</a>
          </li>
          <li>
            <a onClick={this.gotoPricing}>Pricing</a>
          </li>
        </ul>
        {child}
      </div>
    );
  }

  pageComponent() {
    switch (this.state.page) {
      case "/about":
        return <About />;
      case "/pricing":
        return <Pricing />;
      default:
        return <Home />;
    }
  }

  gotoHome(event) {
    event.preventDefault();
    this.setState({ page: "/home" });
  }

  gotoAbout(event) {
    event.preventDefault();
    this.setState({ page: "/about" });
  }

  gotoPricing(event) {
    event.preventDefault();
    this.setState({ page: "/pricing" });
  }
}

export default Main;
