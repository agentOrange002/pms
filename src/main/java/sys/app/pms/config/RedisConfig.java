package sys.app.pms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@SuppressWarnings("deprecation")
	@Bean
	public static LettuceConnectionFactory redisConnectionFactory() {
		LettuceConnectionFactory lcf = new LettuceConnectionFactory();
		lcf.setHostName("127.0.0.1");
		lcf.setPort(6379);
		lcf.afterPropertiesSet();
		return lcf;
	}

	@Bean
	public static RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();	
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
		/*
		 * redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer() );
		 * redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
		 * redisTemplate.setEnableTransactionSupport(true);
		 */
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

}