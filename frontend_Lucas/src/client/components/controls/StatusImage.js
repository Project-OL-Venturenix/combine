import React from 'react';
import PropTypes from 'prop-types';

class StatusImage extends React.Component {
  render() {
    const { hasError, message } = this.props;

    if (hasError) {
      return <div style={{ fontSize: '20px', color: '#D0312D' ,width: '200px'}}>Test case failed</div>;
    } else if (message !== '') {
      return <div style={{ fontSize: '20px', color: '#03AC13' ,width: '200px'}}>Congratulations! You solved this challenge.</div>;
    }

    return null;
  }
}

StatusImage.propTypes = {
  hasError: PropTypes.bool.isRequired,
  message: PropTypes.string.isRequired,
};

export default StatusImage;
