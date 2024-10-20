package calculator;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        int result = 0;
        String customSeperator = new String();

        try {
            if (StringUtils.isNotBlank(input)) {
                // 커스텀 구분자 지정 여부 확인
                if (input.startsWith("//") && input.charAt(3) == 92 && input.charAt(4) == 'n') {
                    char customSeperatorChar = input.charAt(2);

                    if (48 <= customSeperatorChar && customSeperatorChar <= 57) {
                        throw new IllegalArgumentException();
                    }

                    customSeperator = Character.toString(customSeperatorChar);
//                    System.out.println("customSeperatorChar = '" + customSeperatorChar + "'");
                }

                if (StringUtils.isBlank(customSeperator)) {
                    String[] splitedInput = input.split(",|:");
                    for (String inputNumber : splitedInput) {
                        int number = Integer.parseInt(inputNumber);
                        if (number < 0)
                            throw new IllegalArgumentException();
                        result += number;
                    }
                }

                if (StringUtils.isNotBlank(customSeperator)) {
                    String subInput = input.substring(5);
                    if (StringUtils.isNotBlank(subInput)) {
                        String[] splitedInput = subInput.split(customSeperator);
                        for (String inputNumber : splitedInput) {
                            int number = Integer.parseInt(inputNumber);
                            if (number < 0)
                                throw new IllegalArgumentException();
                            result += number;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        System.out.println("결과 : " + result);
    }
}
