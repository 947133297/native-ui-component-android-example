import PropTypes from 'prop-types';
import {requireNativeComponent, ViewPropTypes} from 'react-native';

var iface = {
    name: 'TextView',
    propTypes: {
        title: PropTypes.string,
        ...ViewPropTypes, // include the default view properties
    },
};

module.exports = requireNativeComponent('RCTTextView', iface);