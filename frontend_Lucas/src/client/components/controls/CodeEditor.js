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
        this.onFocus = this.onFocus.bind(this); //
        this.preventCopyPaste = this.preventCopyPaste.bind(this);
    }

    onChange(newValue) {
        this.props.onChange(newValue);
    }

    onFocus(event) { //
        if (this.props.onFocus) {
            this.props.onFocus(event);
        }
    }

    preventCopyPaste(editor, event) {
        console.log('Copying and pasting is not allowed!');
        event.preventDefault();
    }

    render() {
        return (
            <AceEditor
                style={editorStyle}
                readOnly={false}
                onChange={this.onChange}
                onCopy={this.preventCopyPaste} // Attach preventCopyPaste to onCopy
                onPaste={this.preventCopyPaste} // Attach preventCopyPaste to onPaste
                onCut={this.preventCopyPaste} // Attach preventCopyPaste to onCut
                onFocus={this.onFocus} //
                width= "100%"
                height="400px"
                mode="java"
                theme="github"
                name="aceCodeEditor"
                // onLoad={this.onLoad}
                fontSize={14}
                showPrintMargin
                showGutter
                highlightActiveLine
                value={this.props.code}
                editorProps={{
                    $blockScrolling: true,
                    enableBasicAutocompletion: true,
                    enableLiveAutocompletion: true,
                    enableSnippets: true,
                }}
                setOptions={{
                    showLineNumbers: true,
                    tabSize: 2,
                }}
            />
        );
    }
}

CodeEditor.propTypes = {
    code: PropTypes.string.isRequired,
    onChange: PropTypes.func.isRequired,
    onFocus: PropTypes.func, //
};

export default CodeEditor;
