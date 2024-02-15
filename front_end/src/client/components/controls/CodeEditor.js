import React from 'react';
import PropTypes from 'prop-types';

// Import Brace and the AceEditor Component
import AceEditor from 'react-ace';

const editorStyle = {
  border: '1px solid lightgray',
};

class CodeEditor extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};

    this.onChange = this.onChange.bind(this);
  }

  onChange(newValue) {
    this.props.onChange(newValue);
  }

  render() {
    return (
      // <AceEditor
      //   style={editorStyle}
      //   readOnly={false}
      //   onChange={this.onChange}
      //   width="100%"
      //   height="500px"
      //   mode="javascript"
      //   theme="xcode"
      //   name="aceCodeEditor"
      //   // onLoad={this.onLoad}
      //   fontSize={14}
      //   showPrintMargin
      //   showGutter
      //   highlightActiveLine
      //   value={this.props.code}
      //   setOptions={{
      //     showLineNumbers: true,
      //     tabSize: 2,
      //     $blockScrolling: true,
      //     enableBasicAutocompletion: true,
      //     enableLiveAutocompletion: false,
      //     enableSnippets: true,
      //     wrapEnabled: true
      //   }}
      // />
      <AceEditor
        placeholder="Placeholder Text"
        mode="javascript"
        theme="tomorrow"
        name="blah2"
        width="100%"
        // onLoad={this.onLoad}
        onChange={this.onChange}
        fontSize={16}
        showPrintMargin={true}
        showGutter={true}
        highlightActiveLine={true}
        value={this.props.code}
        setOptions={{
          enableBasicAutocompletion: false,
          enableLiveAutocompletion: false,
          enableSnippets: false,
          showLineNumbers: true,
          tabSize: 2,
        }} />

    );
  }
}

CodeEditor.propTypes = {
  code: PropTypes.string.isRequired,
  onChange: PropTypes.func.isRequired,
};

export default CodeEditor;
