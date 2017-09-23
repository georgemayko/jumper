package br.com.gm.jumper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.gm.jumper.model.BoardTest;
import br.com.gm.jumper.model.JumperTest;
import br.com.gm.jumper.model.MoveTest;
import br.com.gm.jumper.model.PositionTest;
import br.com.gm.jumper.model.StoneTest;
import br.com.gm.jumper.model.XYAxisTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    BoardTest.class,
    JumperTest.class,
    PositionTest.class,
    StoneTest.class,
    XYAxisTest.class,
    MoveTest.class
})
public class AppTest 
{
    
}
