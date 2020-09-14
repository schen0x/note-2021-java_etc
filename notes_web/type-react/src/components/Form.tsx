import React, { Component } from "react";
import ReactDOM from "react-dom";

interface FormProps {
  value: string;
}
interface FormState {
  value1: string;
  value2: string;
}

class Form extends Component<FormProps, FormState> {
  constructor(props: FormProps) {
    super(props);

    this.state = {
      value1: "1",
      value2: "2"
    };

    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    const { value } = event.target;
    this.setState(() => {
      return {
        value1: this.state.value1 + " " + value,
      };
    });
    console.log(this.state);
  }

  render() {
    return (
      <form>
        <input
          type="text"
          value={this.state.value1}
          onChange={this.handleChange}
        />
      </form>
    );
  }
}

export default Form;

const wrapper = document.getElementById("container");
wrapper ? ReactDOM.render(<Form value="propValueString" />, wrapper) : false;