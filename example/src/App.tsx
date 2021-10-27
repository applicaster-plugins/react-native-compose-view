import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import { ComposeViewView } from 'react-native-compose-view';

export default function App() {
  return (
    <View style={styles.container}>
      <ComposeViewView color="#32a852" style={styles.box} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 300,
    height: 500,
    marginVertical: 20,
  },
});
