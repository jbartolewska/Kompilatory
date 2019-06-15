package jj;

import jj.gen.Python3Lexer;
import jj.gen.Python3Parser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static void main( String[] args ) throws IOException {
//        CharStream input = null;
//        try {
//            input = (CharStream) new ANTLRFileStream("test.py");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ANTLRInputStream input = new ANTLRInputStream(System.in);
        CharStream input = CharStreams.fromFileName("Q:\\studia\\INF, semestr VI\\kompilatory\\antlr-project\\src\\main\\java\\jj\\test.py");
//        CharStream input = CharStreams.fromString("1+2");
        Python3Lexer lexer = new Python3Lexer(input);
        Python3Parser parser = new Python3Parser(new CommonTokenStream(lexer));
        ParseTree tree=parser.single_input();


        BufferedWriter writer=new BufferedWriter(new FileWriter("output.txt"));
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new Python3CustomListener(writer),tree);
        System.out.println();

//        parser.addParseListener(new Python3CustomListener());


//        ParseTree tree = parser.arith_expr();
//        System.out.println(tree.toStringTree(parser));

    }
}
