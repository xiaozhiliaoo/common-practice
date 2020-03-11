package org.lili.google.guava;

import com.google.common.base.*;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.net.MediaType;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author lili
 * @date 2020/1/16 19:20
 * @description
 */


public class GuavaBaseTest {

    private static final Splitter SPLITTER = Splitter.on(",").trimResults();

    private static final Joiner JOINER = Joiner.on(",").skipNulls();

    @Test
    public void testPreconditions() {
        drive("car1", 0.4d, true);
    }


    public void drive(String carName, double speed, boolean engine) {
        Preconditions.checkNotNull(carName); //NPE
        Preconditions.checkArgument(speed > 0, "speed (%s) must be positve", speed); //IAE
        Preconditions.checkState(engine, "engine must be running");//ISE
    }

    @Test
    public void testToString() {
        // Objects.hashCode()
    }

    @Test
    public void testStopWatch() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        TimeUnit.MILLISECONDS.sleep(2000);
        long elapsedMill = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(elapsedMill);
        //human readable format
        System.out.println(stopwatch.toString());
    }

    @Test
    public void testSplit() {
        String confuse = " foo, ,bar, quxx, ";
        System.out.println(Arrays.toString(confuse.split(",")));
        //omit 忽略
        Iterable<String> split = Splitter.on(",").trimResults().omitEmptyStrings().split(confuse);

        SPLITTER.split(confuse);

        //List<String> strings = Splitter.on("L").splitToList("ETC3LUSDT");
        Assert.assertEquals(Lists.newArrayList("ETC3L","USDT"),spliter("ETC3LUSDT"));
        Assert.assertEquals(Lists.newArrayList("ETC3S","USDT"),spliter("ETC3SUSDT"));

    }

    private List<String> spliter(String s) {
        String s1 = "";
        String s2 = "";
        if(s.contains("L")) {
            String[] ls = s.split("L");
             s1 = ls[0] + "L";
             s2 = ls[1];
        }else if(s.contains("S")) {
            String[] ls = s.split("L");
            s1 = ls[0] + "S";
            s2 = ls[1];
        }
        return Lists.newArrayList(s1, s2);
    }

    @Test
    public void testJoiner() {
        //without NPE
        String join = Joiner.on(",").skipNulls().join("Kurt", "Kevin", null, "Chris");
        Assert.assertEquals("Kurt,Kevin,Chris", join);
        String joinWithNull = Joiner.on(",").useForNull("null").join("Kurt", "Kevin", null, "Chris");
        Assert.assertEquals("Kurt,Kevin,null,Chris", joinWithNull);
    }

    @Test
    public void testCharMatcher() {
        String dddd = CharMatcher.digit().or(CharMatcher.is('-')).retainFrom("1123-444");
        System.out.println(dddd);
    }

    @Test
    public void testOptional() {
        Optional<String> str = Optional.of("new String()");
        Optional<Object> absent = Optional.absent();
        Optional<Object> objectOptional = Optional.fromNullable(null);
        System.out.println(objectOptional.get());
        MediaType mediaType = MediaType.ANY_TYPE;
        mediaType.charset().get();
        mediaType.charset().or(Charsets.UTF_8);
        mediaType.charset().orNull();
        mediaType.charset().asSet();
        //mediaType.charset().transform();
    }

    class Client{

        public boolean activeInLastMonth() {
            return false;
        }
    }

    @Test
    public void testFunctional() {
        Predicate<Client> activeClients = new Predicate<Client>() {
            @Override
            public boolean apply(@Nullable Client client) {
                return client.activeInLastMonth();
            }
        };

        List<Client> c = new ArrayList<>();
        c.add(new Client());
        c.add(new Client());
        c.add(new Client());

        ImmutableList<String> strings = FluentIterable
                .from(c)
                .filter(activeClients)
                .transform(Functions.toStringFunction())
                .limit(10)
                .toList();

    }
}
