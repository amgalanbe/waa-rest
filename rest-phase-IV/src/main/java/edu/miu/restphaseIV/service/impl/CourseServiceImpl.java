package edu.miu.restphaseIV.service.impl;

import edu.miu.restphaseIV.dto.CourseDto;
import edu.miu.restphaseIV.entity.Course;
import edu.miu.restphaseIV.repository.CourseRepo;
import edu.miu.restphaseIV.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    @Override
    public void save(CourseDto courseDto) {
        courseRepo.save(modelMapper.map(courseDto, Course.class));
    }

    @Override
    public void update(CourseDto courseDto) {
        courseRepo.update(modelMapper.map(courseDto, Course.class));
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public CourseDto getById(int id) {
        var course = courseRepo.getById(id);
        return (course != null) ? modelMapper.map(course, CourseDto.class) : null;
    }

    @Override
    public List<CourseDto> getAll() {
        var courses = courseRepo.getAll();
        return courses.stream().map(c -> modelMapper.map(c, CourseDto.class)).collect(Collectors.toList());
    }
}
