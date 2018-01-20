/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
    View,
    Text,
    StyleSheet,
} from 'react-native';

import Tv from './TextView'

const styles = StyleSheet.create({
    red: {
        height:90,
        borderBottomWidth:2,
        borderBottomColor:"blue"
    },
});

const _onChange = (evt)=>{
    console.log("onChange exec")
    console.log(evt.nativeEvent.message) //myEventData
}

export default class App extends Component<{}> {
    render() {
        return <View>
            <Text style={styles.red} >555555555555</Text>
                <Tv style={styles.red} title={"333333"} onChange={_onChange}/>
            <Text style={styles.red}>66666</Text>
        </View>;
    }
}
