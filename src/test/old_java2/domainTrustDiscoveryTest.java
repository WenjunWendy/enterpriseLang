import org.junit.Test;

import core.*;
import attack.*;

public class domainTrustDiscoveryTest{

    @Test
    public void test1(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Windows windows = new Windows("windows" ,false,false,false,false,false
                                                ,false,true,false,false,false
                                                ,false,false,false,false,false
                                                ,false,false,false,false,false
                                                ,false,false,false);

        // Section 2: Asset connections and attacker creation
        user.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        windows.trustedDomainInfo.assertUncompromised();
    }
    @Test
    public void test2(){
        // Section 1: Asset instantiation
        User user = new User("user");
        Windows windows = new Windows("windows");

        // Section 2: Asset connections and attacker creation
        user.addWindows(windows);

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(user.userRights);
        attacker.attack();

        // Section 3: Assertions
        windows.trustedDomainInfo.assertCompromisedInstantaneously();
    }
}