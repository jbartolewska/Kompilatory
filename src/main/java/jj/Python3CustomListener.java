package jj;

import jj.gen.Python3BaseListener;
import jj.gen.Python3Parser;
import java.io.BufferedWriter;
import java.io.IOException;

public class Python3CustomListener extends Python3BaseListener {
    private BufferedWriter writer;
    private boolean for_flag=false;
    private String iterator_name;
    private boolean has_iterator_flag, range_flag;

    Python3CustomListener(BufferedWriter writer){
        this.writer = writer;
    }

    @Override public void enterClassdef(Python3Parser.ClassdefContext ctx) {
        try {
            writer.write("public class"+ctx.NAME().getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void exitClassdef(Python3Parser.ClassdefContext ctx) {
        try {
            writer.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void enterFor_stmt(Python3Parser.For_stmtContext ctx) {
        try {
            writer.write(ctx.FOR().getText()+"(int ");
            for_flag=true;
            has_iterator_flag=false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void enterTrailer(Python3Parser.TrailerContext ctx) {
        try {
            writer.write(ctx.OPEN_PAREN().getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override public void exitTrailer(Python3Parser.TrailerContext ctx) {
        try {
            writer.write(ctx.CLOSE_PAREN().getText());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override public void enterAtom(Python3Parser.AtomContext ctx) {
        try {
            if (for_flag && !has_iterator_flag){
                iterator_name=ctx.NAME().getText();
                has_iterator_flag=true;
            }
            else if (ctx.NAME().getText().equals("range")){
                range_flag=true;
            }
            else if(range_flag){
                writer.write("int " + iterator_name + "=" +ctx.NAME().getText()+";" + iterator_name + "<=");
                range_flag=false;
            }
            else if (ctx.NAME().getText().equals("print")){
                writer.write("System.out.println");
            }
            else{
                writer.write(ctx.NAME().getText());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void exitTestlist(Python3Parser.TestlistContext ctx) {
        try {
            writer.write(";" +iterator_name+"++){");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Override public void enterExpr_stmt(Python3Parser.ClassdefContext ctx) {
//        try {
//            writer.write("=");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


//    @Override public void enterAtom(Python3Parser.AtomContext ctx) {
//        if (ctx.STRING().isEmpty()){
//
//        }
//
//        int value=Integer.valueOf(ctx.NUMBER().getText());
//        System.out.print(value);
//    }

}
