- Java
    
    ```java
    import java.io.*;
    import java.util.*;
    
    public class Main {
        public static void main(String args[]) throws Exception {
            Scanner cin=new Scanner(System.in); //java.util.Scanner
            int a = cin.nextInt();
            int b = cin.nextInt();
            String s = cin.next();
            System.out.println(a + b);
        }
    }
    ```
- JavaScript
    
    ```jsx
    var fs = require('fs');
    var buf = '';
    
    process.stdin.on('readable', function() {
      var chunk = process.stdin.read();
      if (chunk) buf += chunk.toString();
    });
    
    process.stdin.on('end', function() {
      buf.split('\n').forEach(function(line) {
        var tokens = line.split(' ').map(function(x) { return parseInt(x); });
        if (tokens.length != 2) return;
        console.log(tokens.reduce(function(a, b) { return a + b; }));
      });
    });
    ```
- C++
    
    ```cpp
    #include <iostream>
    
    using namespace std;
    
    int main () {
        int a, b;
        cin >> a >> b;
        cout << a + b << endl;
        return 0;
    }
    ```
- C
    
    ```c
    #include <stdio.h>
    
    int main()
    {
        int a, b;
        scanf("%d%d", &a, &b);
        printf("%d\n", a + b);
        return 0;
    }
    ```
- Python3
    
    ```python
    import sys
    
    for line in sys.stdin:
        print(sum(map(int, line.split())))
    ```
- Python
    
    ```python
    import sys
    
    for line in sys.stdin:
        print sum(map(int, line.split()))
    ```
- Go
    
    ```go
    package main
    
    import "fmt"
    
    func main() {
      var a, b int
      for {
        n, _ := fmt.Scanf("%d %d", &a, &b)
        if n != 2 { break }
        fmt.Println(a + b)
      }
    }
    ```