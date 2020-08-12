import React from 'react';
import {AppRegistry, StyleSheet, Text, View,Image} from 'react-native';

const styles0 = StyleSheet.create({
    container: {
        paddingTop: 50,
    },
    stretch: {
        width: 200,
        height: 200,
        resizeMode: 'stretch',
    },
});

class HelloWorld extends React.Component {
    render() {
        return (
            <View style={styles0.container}>
            <Text style={styles.hello}>Hello, World</Text>
                <Image
                    style={styles0.stretch}
                    source={{
                        uri: 'https://desk-fd.zol-img.com.cn/t_s960x600c5/g5/M00/09/03/ChMkJl3I0dmIAiyXABDF46MVj1IAAvKLgFJsZUAEMX7384.jpg',
                    }}
                />
        </View>
    );
    }
}
const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
    },
    hello: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
});

AppRegistry.registerComponent('MyReactNativeApp', () => HelloWorld);
