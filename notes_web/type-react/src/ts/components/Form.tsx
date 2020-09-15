import React, { Component } from "react";

interface FormProps {
  formName: string;
}
interface FormState {
  userStrInput: string;
}

class Form extends Component<FormProps, FormState> {
  constructor(props: FormProps) {
    super(props);

    this.state = {
      userStrInput: "",
    };

    this.userTextInputOnChangeHandler = this.userTextInputOnChangeHandler.bind(this);
  }

  userTextInputOnChangeHandler(event: React.ChangeEvent<HTMLInputElement>) {
    const { value } = event.target;
    this.setState(() => {
      return {
        userStrInput: value,
      };
    });
    console.log(this.state);
  }

  render() {
    return (
      <form>
        <input
          type="text"
          placeholder="String Input"
          value={this.state.userStrInput}
          onChange={this.userTextInputOnChangeHandler}
        />
      </form>
    );
  }
}

export default Form;